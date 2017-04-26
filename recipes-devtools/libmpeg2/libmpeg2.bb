DESCRIPTION = "EMUTILS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit autotools

PR = "r0"
PV = "1.0"
SRCBRANCH = "master"
SRCREV = "9beb2828719265e9d823b3bf3dd2f8d8a8579b05"

SRC_URI = "git://git@192.168.3.200:10022/utils/libmpeg2.git;branch=${SRCBRANCH};protocol=ssh"
S = "${WORKDIR}/git"

EXTRA_OECONF += "--disable-sdl --host=arm"

# prevent already-stripped QA Issue
INHIBIT_SYSROOT_STRIP = "1"
INSANE_SKIP_${PN} += "installed-vs-shipped"

PACKAGES = "mpeg2decg2d"
RDEPENDS_mpeg2decg2d = "imx-gpu-viv-g2d"
FILES_mpeg2decg2d = "${bindir}/mpeg2dec"

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${B}/src/mpeg2dec ${D}${bindir}
}
