# Copyright (C) Max Mu
# DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
# 
# This program is free software; you can redistribute it and/or
# modify it under the terms of the GNU General Public License
# version 2, as published by the Free Software Foundation.
# 
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License version 2 for more details.
# 
# You should have received a copy of the GNU General Public License
# along with this program; if not, write to the Free Software
# Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
# 
# Please visit www.joshvm.org if you need additional information or
# have any questions.

MODULE_NAME = josh-dio
JSR_JAVA_FILES_DIR += $(DIO_DIR)/src/classes
DOC_SOURCE_$(MODULE_NAME)_PATH=$(BUILD_ROOT_DIR)/dio/src/classes
DOC_SOURCE_PATH := $(DOC_SOURCE_PATH)$(DOC_SOURCE_$(MODULE_NAME)_PATH)$(DOC_PATH_SEP)
DOC_$(MODULE_NAME)_PACKAGES += org.joshvm.j2me.dio org.joshvm.j2me.dio.gpio org.joshvm.j2me.dio.spibus org.joshvm.j2me.dio.i2cbus
