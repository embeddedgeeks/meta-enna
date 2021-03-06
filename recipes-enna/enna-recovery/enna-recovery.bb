DESCRIPTION = "Enna box recovery scripts"
HOMEPAGE = "http://enna.me"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r0"

SRC_URI = "file://enna-recovery.sh \
        file://enna-recovery.service \
        file://nand-part.output \
        file://nand.bin \
        file://nanda.bin \
        file://nandb.bin"

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE = "${PN}.service"

do_install() {
    install -d ${D}/${sbindir}
    install -d ${D}/${datadir}/${PN}
    install -m 0755 ${WORKDIR}/${PN}.sh ${D}/${sbindir}
    install -m 644 ${WORKDIR}/nand* ${D}/${datadir}/${PN}/
}
FILES_${PN} += "/sbin/ ${datadir}"
PACKAGE_ARCH = "all"
