require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot for Fangyan imx6 boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
COMPATIBLE_MACHINE = "wisehmi"

PROVIDES = "u-boot"

PR = "r0"
PV = "2014.10+git${SRCPV}"
SRCBRANCH = "v2014.10"
SRCREV = "${AUTOREV}"
SRC_URI = " \ 
    git://git@192.168.3.200:10022/imx6/das-uboot.git;branch=${SRCBRANCH};protocol=ssh \
"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

EXTRA_OEMAKE = 'CROSS_COMPILE=/usr/bin/arm-linux-gnueabihf-'
