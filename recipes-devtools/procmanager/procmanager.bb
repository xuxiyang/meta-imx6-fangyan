DESCRIPTION = "manager for control play startup animation、run qt program、monitor qt program"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
PV = "1.0"
SRCBRANCH = "master"
SRCREV = "f5b0a8557566e0ee948670b4a62c297183f67ea3"

SRC_URI = "git://git@192.168.3.200:10022/utils/procManager.git;branch=${SRCBRANCH};protocol=ssh"
S = "${WORKDIR}/git"

# prevent already-stripped QA Issue
INHIBIT_SYSROOT_STRIP = "1"

INITSCRIPT_NAME = "init-procmanager"
INITSCRIPT_PARAMS = "start 00 5 . stop 00 6 ."

inherit update-rc.d

do_compile () {
    make
}

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/init.d/
    install -m 755 ${B}/procManager ${D}${bindir}
    install -m 755 ${B}/procmanager.ini ${D}${sysconfdir}
    install -m 755 ${B}/S00procmanager ${D}${sysconfdir}/init.d/init-procmanager
}

