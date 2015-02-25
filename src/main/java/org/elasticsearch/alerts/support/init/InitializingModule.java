/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.alerts.support.init;

import org.elasticsearch.alerts.support.init.proxy.ClientProxy;
import org.elasticsearch.alerts.support.init.proxy.ScriptServiceProxy;
import org.elasticsearch.alerts.transform.ChainTransform;
import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.inject.multibindings.Multibinder;

/**
 *
 */
public class InitializingModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(ClientProxy.class).asEagerSingleton();
        bind(ScriptServiceProxy.class).asEagerSingleton();

        Multibinder<InitializingService.Initializable> mbinder = Multibinder.newSetBinder(binder(), InitializingService.Initializable.class);
        mbinder.addBinding().to(ClientProxy.class);
        mbinder.addBinding().to(ScriptServiceProxy.class);
        mbinder.addBinding().to(ChainTransform.Parser.class);
        bind(InitializingService.class).asEagerSingleton();
    }
}
