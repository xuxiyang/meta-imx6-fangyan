DESCRIPTION = "Generate pack.img"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pack_img

DEPENDS += "virtual/kernel"

PV = "1.0"

BASE_KERNEL_DEVICETREE_mx6q = "imx6q-wisehmi.dtb"
BASE_KERNEL_DEVICETREE_mx6dl = "imx6dl-wisehmi.dtb"

do_compile() {
    ln -snf zImage-${KERNEL_DEVICETREE} ${DEPLOY_DIR_IMAGE}/${BASE_KERNEL_DEVICETREE}
    packimg -p512 ${DEPLOY_DIR_IMAGE}/${BASE_KERNEL_DEVICETREE}@0x12000000 ${DEPLOY_DIR_IMAGE}/zImage@0x10008000 ${B}/${PACK_IMG}
    rm ${DEPLOY_DIR_IMAGE}/${BASE_KERNEL_DEVICETREE}
}

do_compile[deptask] = "do_deploy"
