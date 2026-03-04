require u-boot-ti.inc

include ${@ 'recipes-bsp/u-boot/ti-extras.inc' if d.getVar('TI_EXTRAS') else ''}

PR = "r0"

BRANCH = "ti-u-boot-2025.01"

SRCREV_uboot = "3ff43d2319dadb150524374ae6d328aff007227b"
