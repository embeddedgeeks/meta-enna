ESCRIPTION = "Calaos Graphical User Insterface"
HOMEPAGE = "http://www.calaos.fr"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR = "r11"

DEPENDS = "libsigc++-2.0 owfs log4cpp libvmime jansson lua5.1 elementary"

SRCREV = "6609524b7f9a070052f4858e2a686e5bfb5447ba"
SECTION = "x11/multimedia"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/calaos/calaos_base.git;protocol=http;branch=master"

inherit autotools gettext systemd update-alternatives

do_configure_prepend() {
    autopoint || touch config.rpath
}

FILES_${PN} = "${bindir}/calaos_home \
	       ${datadir}/calaos/* \
	       ${datadir}/locale/*"


ALTERNATIVE_${PN} = "x-window-manager"
ALTERNATIVE_TARGET[x-window-manager] = "${bindir}/calaos_home"
ALTERNATIVE_PRIORITY[x-window-manager] = "10"
