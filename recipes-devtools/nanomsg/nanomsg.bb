DESCRIPTION = "EMUTILS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cmake

SRC_URI = "git://github.com/nanomsg/nanomsg.git;protocol=http;tag=1.1.0"

S = "${WORKDIR}/git"

#FILES_${PN} = "${libdir}/libnanomsg.so*"

export EXTRA_OECMAKE = "-DCMAKE_INSTALL_PREFIX=/usr"

