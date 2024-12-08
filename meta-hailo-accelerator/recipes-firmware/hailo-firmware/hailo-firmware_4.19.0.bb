DESCRIPTION = "hailo firmware \
				hailo8 chip firmware (hailo_fw.bin) \
				the recipe copies the file to /lib/firmware/hailo/ on the target device’s root file system"

BASE_URI = "https://hailo-hailort.s3.eu-west-2.amazonaws.com"
FW_AWS_DIR = "Hailo8/${PV}/FW"
FW = "hailo8_fw.${PV}.bin"
LICENSE_FILE = "LICENSE"
SRC_URI = "${BASE_URI}/${FW_AWS_DIR}/${FW};md5sum=4494928bbf4fea0ed5e52c26fa043e38 \
		${BASE_URI}/${FW_AWS_DIR}/${LICENSE_FILE};md5sum=263ee034adc02556d59ab1ebdaea2cda"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/${LICENSE_FILE};md5=263ee034adc02556d59ab1ebdaea2cda"

FW_PATH = "${WORKDIR}/hailo8_fw.${PV}.bin"

do_install() {
	# Stores hailo8_fw.bin in the rootfs under /lib/firmware/hailo
	install -d ${D}${nonarch_base_libdir}/firmware/hailo
	install -m 0755 ${FW_PATH} ${D}${nonarch_base_libdir}/firmware/hailo/hailo8_fw.bin
}

FILES:${PN} += "${nonarch_base_libdir} ${nonarch_base_libdir}/* ${nonarch_base_libdir}/firmware/hailo/hailo8_fw*"
