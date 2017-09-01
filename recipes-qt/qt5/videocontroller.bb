DESCRIPTION =  "EMUTILS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-qt/qt5/qt5.inc

DEPENDS += " \
    qtdeclarative \
"
PR = "r0"
PV = "1.0"
SRCBRANCH = "master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
SRC_URI = "git://git@192.168.3.200:10022/qt/videoController.git;branch=${SRCBRANCH};protocol=ssh"
