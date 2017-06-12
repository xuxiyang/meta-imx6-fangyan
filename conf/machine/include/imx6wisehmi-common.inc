# Provides the i.MX6 WiseHMI common settings

MACHINEOVERRIDES = "wisehmi:${MACHINE}"
MACHINE_CLASS = "wisehmi"

require conf/machine/include/imx-base.inc
require conf/machine/include/tune-cortexa9.inc

SERIAL_CONSOLE = "115200 ttymxc3"

PREFERRED_PROVIDER_u-boot = "u-boot-imx6-fangyan"
#PREFERRED_VERSION_u-boot-imx6-fangyan = "2014.10"

PREFERRED_PROVIDER_virtual/kernel = "linux-imx6-fangyan"
#PREFERRED_VERSION_linux-imx6-fangyan = "3.14.52"

PREFERRED_PROVIDER_busybox = "busybox-fangyan"

PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"

PREFERRED_VERSION_glmark2 = "git"

KERNEL_IMAGETYPE = "zImage"

IMAGE_FSTYPES = "tar.bz2"

MACHINE_FEATURES_remove = "usbgadget usbhost alsa touchscreen rtc"

# remove getty tty* from /etc/inittab
USE_VT = "0"

SPL_BINARY = "SPL"
UBOOT_SUFFIX = "img"
UBOOT_MAKE_TARGET = "all"

KERNEL_MODULE_AUTOLOAD += "af_packet fec mii smsc unix fsl_otp r8152"
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
    kernel-module-af-packet \
    kernel-module-fec \
    kernel-module-mii \
    kernel-module-smsc \
    kernel-module-unix \
    kernel-module-fsl-otp \
    kernel-module-r8152 \
"
# usb to rs232
KERNEL_MODULE_AUTOLOAD += "ch341 ftdi_sio pl2303"
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
    kernel-module-ch341 \
    kernel-module-pl2303 \
    kernel-module-ftdi-sio \
"

LICENSE_FLAGS_WHITELIST="commercial"
MACHINE_ARCH_FILTER += "qtbase-static"

FP_TAG = "${@base_contains("TUNE_FEATURES", "callconvention-hard", "-hfp", "-sfp", d)}"
PREFERRED_VERSION_imx-gpu-viv = "5.0.11.p8.3${FP_TAG}"

MACHINE_HAS_VIVANTE_KERNEL_DRIVER_SUPPORT = "1"
MACHINE_USES_VIVANTE_KERNEL_DRIVER_MODULE = "0"
