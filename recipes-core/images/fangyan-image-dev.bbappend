IMAGE_FSTYPES += "ext4"
#IMAGE_INSTALL += "mmdc"

IMAGE_INSTALL += "initscript-resize2fs eglinfo-fb \
	mpeg2decg2d procmanager \
"

IMAGE_INSTALL_append_imx6qwisehmi += " \
    imx-test \
"

IMAGE_INSTALL_append_imx6dlwisehmi += " \
    imx-test \
"
