/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
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
package org.hawkular.btm.api.model.config.instrumentation;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModel;

/**
 * This abstract class represents the base type for all instrumentation based actions.
 *
 * @author gbrown
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = InstrumentComponent.class), @Type(value = InstrumentConsumer.class),
    @Type(value = InstrumentProducer.class), @Type(value = FreeFormAction.class),
    @Type(value = ProcessContent.class), @Type(value = SetDetail.class),
    @Type(value = SetFault.class), @Type(value = SetName.class), @Type(value = SetLevel.class),
    @Type(value = SetProperty.class), @Type(value = InitiateCorrelation.class),
    @Type(value = CompleteCorrelation.class), @Type(value = Correlate.class),
    @Type(value = Unlink.class), @Type(value = AssertComplete.class), @Type(value = Suppress.class),
    @Type(value = ProcessHeaders.class), @Type(value = SetPrincipal.class) })
@ApiModel(subTypes = { InstrumentComponent.class, InstrumentConsumer.class,
        InstrumentProducer.class, FreeFormAction.class, ProcessContent.class,
        SetDetail.class, SetFault.class, SetName.class, SetLevel.class, SetProperty.class, InitiateCorrelation.class,
        CompleteCorrelation.class, Correlate.class, Unlink.class, AssertComplete.class, Suppress.class,
        ProcessHeaders.class, SetPrincipal.class },
        discriminator = "type")
public abstract class InstrumentAction {

}
