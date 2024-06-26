DESCRIPTION = "Units to initialize usb gadgets"

PR = "r19"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

COMPATIBLE_MACHINE = "(ti33x)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://storage-gadget-init.service \
           file://network-gadget-init.service \
           file://udhcpd.service \
           file://udhcpd.conf \
           file://bone-gmass-eject.rules \
           file://udhcpd.rules \
           file://g-storage-reinsert.sh \
           file://g-ether-start-service.sh \
           file://g-ether-load.sh \
           file://update-image-info-on-mmcblk0p1.sh \
          "

do_install() {
	install -d ${D}${base_libdir}/systemd/system/basic.target.wants
	install -m 0644 ${UNPACKDIR}/*.service ${D}${base_libdir}/systemd/system

	for i in ${UNPACKDIR}/storage-gadget-init.service ; do
		install -m 0644 $i ${D}${base_libdir}/systemd/system
		ln -sf ../$(basename $i) ${D}${base_libdir}/systemd/system/basic.target.wants/
	done

	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${UNPACKDIR}/*.rules ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${UNPACKDIR}/*.conf ${D}${sysconfdir}

	install -d ${D}${bindir}
	install -m 0755 ${UNPACKDIR}/*.sh ${D}${bindir}
}

PACKAGES =+ "${PN}-storage ${PN}-network ${PN}-udhcpd"

ALLOW_EMPTY:${PN} = "1"

FILES:${PN}-storage = "${base_libdir}/systemd/system/storage-gadget-init.service \
                       ${base_libdir}/systemd/system/basic.target.wants/storage-gadget-init.service \
                       ${bindir}/g-storage-reinsert.sh \
                       ${bindir}/update-image-info-on-mmcblk0p1.sh \
                       ${sysconfdir}/udev/rules.d/bone-gmass-eject.rules"

FILES:${PN}-network = "${base_libdir}/systemd/system/network-gadget-init.service \
                       ${base_libdir}/systemd/system/basic.target.wants/network-gadget-init.service \
                       ${bindir}/g-ether-load.sh \
                       ${bindir}/g-ether-start-service.sh \
                       ${sysconfdir}/udev/rules.d/udhcpd.rules"

FILES:${PN}-udhcpd = "${base_libdir}/systemd/system/udhcpd.service \
                      ${base_libdir}/systemd/system/basic.target.wants/udhcpd.service \
                      ${sysconfdir}/udhcpd.conf"

RRECOMMENDS:${PN} = "${PN}-storage ${PN}-network ${PN}-udhcpd"
