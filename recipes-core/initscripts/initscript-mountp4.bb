SUMMARY = "init script for fangyan boards startup"
SECTION = "fangyan"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://initscript-mountp4"

INITSCRIPT_NAME = "initscript-mountp4"
INITSCRIPT_PARAMS = "start 86 S ."

inherit update-rc.d

S = "${WORKDIR}"

do_compile () {
}

do_install () {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/initscript-mountp4 ${D}${sysconfdir}/init.d/
}
