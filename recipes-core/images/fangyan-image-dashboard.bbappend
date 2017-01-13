IMAGE_TYPES += "cpio.packimg"
COMPRESSIONTYPES += "packimg"
COMPRESS_CMD_packimg = "packimg -p512 -n ${IMAGE_NAME}.rootfs.${type}@0x12800000 ${IMAGE_NAME}.rootfs.${type}.packimg"
COMPRESS_DEPENDS_packimg = "emutils-native"

IMAGE_FSTYPES += "cpio.packimg"

#IMAGE_INSTALL += " mpeg2decg2d"
#IMAGE_INSTALL_append_imx6dlwisehmi-motor += " dashboard-motor"

pre_process_image_cpio() {
    install -d ${IMAGE_ROOTFS}/initroot
    find ${IMAGE_ROOTFS} -mindepth 1 -not -name initroot -prune -print0 | xargs -0 mv --target-directory=${IMAGE_ROOTFS}/initroot
}

IMAGE_PREPROCESS_COMMAND += "pre_process_image_cpio;"

IMAGE_CMD_cpio () {
    (cd ${IMAGE_ROOTFS} && find initroot | cpio -o -H newc >${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.cpio)
}
