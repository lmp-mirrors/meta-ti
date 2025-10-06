require u-boot-ti.inc

include ${@ 'recipes-bsp/u-boot/ti-extras.inc' if d.getVar('TI_EXTRAS') else ''}

PR = "r0"

BRANCH = "ti-u-boot-2025.01"

SRCREV_uboot = "c779c758475cb98e95d3c05744e0dcbca5fc9991"

SRC_URI += "\
    file://0001-kconfig-Add-support-for-external-config-fragment-and.patch \
"

TI_SIGN_WITH_ECDSA_KEY = "KEY_PATH=${THISDIR}/files/custMpk_ecdsa.key"
