LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://Makefile;beginline=1;endline=35;md5=286cbb5dce3e348294b6b025cff969b3"

COMPATIBLE_MACHINE = "ti33x|ti43x"
PACKAGE_ARCH = "${MACHINE_ARCH}"

STARTERWARE_GIT_URI = "git://git.ti.com/git/keystone-rtos/starterware.git"
STARTERWARE_GIT_PROTOCOL = "https"
STARTERWARE_GIT_BRANCH = "master"

# Below commit ID corresponds to "DEV.STARTERWARE.PROCSDK.02.01.01.12A"
STARTERWARE_SRCREV = "49a4d4cd4c72bacee738d44b8e72e7f59aa948cd"

BRANCH = "${STARTERWARE_GIT_BRANCH}"
SRC_URI = "${STARTERWARE_GIT_URI};protocol=${STARTERWARE_GIT_PROTOCOL};branch=${BRANCH}"

SRCREV = "${STARTERWARE_SRCREV}"
PV = "02.01.01.12A"
INC_PR = "r0"

S = "${WORKDIR}/git"