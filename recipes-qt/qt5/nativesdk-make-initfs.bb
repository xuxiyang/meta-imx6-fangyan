SUMMARY = "Postinstall make.initfs stuff"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit nativesdk

# prevent already-stripped QA Issue
INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} += " \
    already-stripped \
    installed-vs-shipped arch \
"

FILESEXTRAPATHS_append := "${THISDIR}/make-initfs:"

SRC_URI += " \
    file://make.data \
    file://make.initfs \
    file://pack.initfs \
"
S = "${WORKDIR}"

FILES_${PN}-dev += " \
    ${bindir}/make.data \
    ${bindir}/make.initfs \
    ${bindir}/pack.initfs \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/pack.initfs ${D}${bindir}
    install -m 755 ${WORKDIR}/make.initfs ${D}${bindir}
    install -m 644 ${WORKDIR}/make.data ${D}${bindir}/dashboard-initfs.tar.bz2
}
