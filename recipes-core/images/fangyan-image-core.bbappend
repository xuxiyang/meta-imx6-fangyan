IMAGE_FSTYPES += "ext4"

ROOTFS_POSTPROCESS_COMMAND_remove = "rootfs_update_timestamp ;"

IMAGE_POSTPROCESS_COMMAND += "generate_corefsmd5 ;"

generate_corefsmd5() {
    md5_file="${DEPLOY_DIR_IMAGE}/corefs.md5"
    touch ${md5_file}
    origin_dir=`pwd`
    cd ${IMAGE_ROOTFS}
    find ./ -type f | xargs md5sum | sed 's/\.//' > ${md5_file}
    cd ${origin_dir}
}
