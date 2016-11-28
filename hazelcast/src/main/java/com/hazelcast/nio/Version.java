/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.nio;

/**
 * A generic version to be used with {@link VersionAware} classes. The version's value is a single byte.
 */
public class Version {

    public static final byte UNKNOWN_VERSION = -1;
    public static final Version UNKNOWN = new Version(UNKNOWN_VERSION);

    private byte value;

    public Version(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Version version = (Version) o;

        return value == version.value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    public static Version of(int value) {
        if (value == UNKNOWN_VERSION) {
            return UNKNOWN;
        } else {
            return new Version(value);
        }
    }
}
