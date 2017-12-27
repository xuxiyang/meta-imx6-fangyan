DESCRIPTION =  "EMUTILS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-qt/qt5/qt5.inc

DEPENDS += " \
    qtdeclarative protobuf-native protobuf nanomsg libmpeg2 \
"
RDEPENDS_${PN} =+ "qtserialport"

PR = "r0"
PV = "1.0"
SRCBRANCH = "master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"
SRC_URI = "git://git@192.168.3.200:10022/qt/newqt.git;branch=${SRCBRANCH};protocol=ssh"

FILES_${PN} += " \
    /home/root/app \
    /home/root/datacenter \
	"
# prevent already-stripped QA Issue
INHIBIT_SYSROOT_STRIP = "1"
INSANE_SKIP_${PN} += "installed-vs-shipped"


do_install () {
        install -d ${D}/usr/lib
        install -d ${D}/home/root

		install -m 0755 ${B}/lib/libmsg.so.1 ${D}/usr/lib/
		install -m 0755 ${B}/datacenter/datacenter ${D}/home/root/datacenter
		install -m 0755 ${B}/qtdisplay/bin/CarInfo ${D}/home/root/app
}

