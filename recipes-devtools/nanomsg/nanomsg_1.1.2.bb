#
# see Yocto Project Development Manual.
#

DESCRIPTION = "nanomsg"
HOMEPAGE = "https://nanomsg.org"
SECTION = "base"
DEPENDS = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=587b3fd7fd291e418ff4d2b8f3904755"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = "git://github.com/nanomsg/nanomsg.git"
SRCREV = "0c1aa2b288f6b167dbafe7e29c20e6fc7e71c000"

S = "${WORKDIR}/git"

inherit cmake pkgconfig


#BBCLASSEXTEND = "native nativesdk"
