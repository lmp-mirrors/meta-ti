require u-boot-ti.inc

include ${@ 'recipes-bsp/u-boot/ti-extras.inc' if d.getVar('TI_EXTRAS') else ''}

PR = "r0"

BRANCH = "ti-u-boot-2023.04"

SRC_URI += "file://0001-scripts-dtc-pylibfdt-libfdt.i_shipped-Use-SWIG_Appen.patch"

SRCREV = "2a13324ec63cc488f5f578886d0cf6ece348dfda"
