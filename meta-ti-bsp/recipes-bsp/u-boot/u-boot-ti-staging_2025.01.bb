require u-boot-ti.inc

PR = "r0"

BRANCH = "ti-u-boot-2025.01"

SRCREV_uboot = "c779c758475cb98e95d3c05744e0dcbca5fc9991"

SRC_URI += "\
    file://0001-kconfig-Add-support-for-external-config-fragment-and.patch \
"
