/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.apm.api.model.trace;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This class represents a Correlation Identifier. These identifies are used to
 * link information generated by multiple systems involved in the execution of
 * a trace instance.
 *
 * @author gbrown
 *
 */
public class CorrelationIdentifier {

    @JsonInclude
    private String value;

    @JsonInclude
    private Scope scope;

    public CorrelationIdentifier() {
    }

    public CorrelationIdentifier(Scope scope, String value) {
        this.value = value;
        this.scope = scope;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the scope
     */
    public Scope getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        // NOTE: Duration should not be used as part of hashcode

        result = prime * result + ((scope == null) ? 0 : scope.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CorrelationIdentifier other = (CorrelationIdentifier) obj;

        // NOTE: Duration should not be evaluated as part of equality,
        // although will be relevant when evaluating whether the correlation
        // identifier is relevant

        if (scope != other.scope) {
            return false;
        }
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CorrelationIdentifier [value=" + value + ", scope=" + scope + "]";
    }

    /**
     * This enumerated value represents the scope of the correlation identifier.
     *
     * @author gbrown
     *
     */
    public enum Scope {

        /**
         * The 'Interaction' scope means the identifier is only unique in relation
         * to a specific exchange between two (or more) participants.
         */
        Interaction

    }
}
