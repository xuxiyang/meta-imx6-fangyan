SUMMARY = "Postinstall make.ui stuff"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit nativesdk

# prevent already-stripped QA Issue
INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} += " \
    already-stripped \
    installed-vs-shipped arch \
"

FILESEXTRAPATHS_append := "${THISDIR}/make-ui:"

SRC_URI += " \
    file://make.ui \
"
S = "${WORKDIR}"

FILES_${PN} += " \
    ${bindir}/make.ui \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/make.ui ${D}${bindir}
}
