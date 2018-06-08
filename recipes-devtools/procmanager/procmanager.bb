DESCRIPTION = "manager for control play startup animation、run qt program、monitor qt program"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
PV = "1.0"
SRCBRANCH = "master"
SRCREV = "${AUTOREV}"
#SRCREV = "84bcbfb3876f7f04693def685562e3942d80bb11"

SRC_URI = "git://git@192.168.3.200:10022/utils/procManager.git;branch=${SRCBRANCH};protocol=ssh"
S = "${WORKDIR}/git"

# prevent already-stripped QA Issue
INHIBIT_SYSROOT_STRIP = "1"

do_compile () {
    make
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${B}/procManager ${D}${bindir}
}

