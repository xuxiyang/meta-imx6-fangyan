DESCRIPTION =  "EMUTILS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-qt/qt5/qt5.inc

DEPENDS += "qtdeclarative"

PR = "r0"
PV = "1.0"
SRCBRANCH = "master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"
SRC_URI = "git://git@192.168.3.200:10022/utils/updater.git;branch=${SRCBRANCH};protocol=ssh"

FILES_${PN} += " \
    /home/root/updater \
	"
# prevent already-stripped QA Issue
INHIBIT_SYSROOT_STRIP = "1"
INSANE_SKIP_${PN} += "installed-vs-shipped"


do_install () {
        install -d ${D}/home/root

		install -m 0755 ${B}/bin/updater ${D}/home/root/updater
}

