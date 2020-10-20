/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.initializr.web.controller.custom;

import java.util.Map;

import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.controller.ProjectGenerationController;
import io.spring.initializr.web.project.ArchetypeProcessor;
import io.spring.initializr.web.project.ProjectGenerationInvoker;

/**
 * A custom {@link ProjectGenerationController} that binds request attributes to a
 * {@link CustomProjectRequest}.
 *
 * @author Stephane Nicoll
 */
class CustomProjectGenerationController extends ProjectGenerationController<CustomProjectRequest> {

	CustomProjectGenerationController(InitializrMetadataProvider metadataProvider,
			ProjectGenerationInvoker<CustomProjectRequest> projectGenerationInvoker,
			ArchetypeProcessor archetypeProcessor) {
		super(metadataProvider, projectGenerationInvoker, archetypeProcessor);
	}

	@Override
	public CustomProjectRequest projectRequest(Map<String, String> headers) {
		CustomProjectRequest request = new CustomProjectRequest();
		request.getParameters().putAll(headers);
		request.initialize(getMetadata());
		return request;
	}

}
