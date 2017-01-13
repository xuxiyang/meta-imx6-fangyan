FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://add-imx6-eglfs.patch"
PACKAGECONFIG_GL = "gles2"

do_configure_prepend() {
    # adapt qmake.conf to our needs
    sed -i 's!load(qt_config)!!' ${S}/mkspecs/linux-oe-g++/qmake.conf

    # copy the hook in the mkspecs directory OE is using
    cp ${S}/mkspecs/devices/linux-imx6-g++/qeglfshooks_imx6.cpp ${S}/mkspecs/linux-oe-g++/

    cat >> ${S}/mkspecs/linux-oe-g++/qmake.conf <<EOF
EGLFS_PLATFORM_HOOKS_SOURCES = \$\$PWD/qeglfshooks_imx6.cpp

QMAKE_LIBS_EGL         += -lEGL
QMAKE_LIBS_OPENGL_ES2  += -lGLESv2 -lEGL

load(qt_config)

EOF
}

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

