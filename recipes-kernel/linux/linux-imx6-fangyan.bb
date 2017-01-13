require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Fangyan imx6 boards"

SRC_URI = " \
    ssh://git@192.168.3.200:10022/imx6/fsl-linux.git;branch=${SRCBRANCH};protocol=ssh \
"

PE = "1"
PR = "r0"
PV = "3.14.52+git${SRCPV}"
SRCBRANCH = "imx_3.14.52_1.1.0_ga"
SRCREV = "${AUTOREV}"

#NOTE: When a project is frozen, SRCREV must using a determined commit.
#SRCREV = "3b8e8232273bb3c1f8d84cb62f7927479ed57d06"

COMPATIBLE_MACHINE = "wisehmi"

DEPENDS += "lz4-native bc-native"
RDEPENDS_kernel-base_remove = "kernel-image"

EXTRA_OEMAKE += " \
    KBUILD_BUILD_USER=${SRCPV} \
    KBUILD_BUILD_HOST=fangyan-dev \
"

SCMVERSION = ""
LOCALVERSION = "-generic"
# Set a variable in .configure
# $1 - Configure variable to be set
# $2 - value [n/y/value]
kernel_configure_variable() {
    # Remove the config
    CONF_SED_SCRIPT="$CONF_SED_SCRIPT /CONFIG_$1[ =]/d;"
    if test "$2" = "n"
    then
        echo "# CONFIG_$1 is not set" >> ${B}/.config
    else
        echo "CONFIG_$1=$2" >> ${B}/.config
    fi
}

do_compile_prepend() {
    kernel_configure_variable LOCALVERSION_AUTO n
}

KBUILD_DEFCONFIG ?= "wisehmi_dev_defconfig"

do_configure_prepend() {
    if [ -n "${KBUILD_DEFCONFIG}"  ]; then
        if [ -f "${S}/arch/${ARCH}/configs/${KBUILD_DEFCONFIG}"  ]; then
            cp -f ${S}/arch/${ARCH}/configs/${KBUILD_DEFCONFIG} ${WORKDIR}/defconfig
        fi
    fi
}

KERNEL_MODULE_PROBECONF += "phy-mxs-usb"
module_conf_phy-mxs-usb = "softdep phy-mxs-usb post: ci_hdrc_imx"
