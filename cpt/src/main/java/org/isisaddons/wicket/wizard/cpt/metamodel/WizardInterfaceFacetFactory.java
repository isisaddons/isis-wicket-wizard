/*
 *  Copyright 2014 Dan Haywood
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.isisaddons.wicket.wizard.cpt.metamodel;

import org.isisaddons.wicket.wizard.cpt.applib.Wizard;
import org.apache.isis.core.metamodel.facetapi.FacetHolder;
import org.apache.isis.core.metamodel.facetapi.FacetUtil;
import org.apache.isis.core.metamodel.facetapi.FeatureType;
import org.apache.isis.core.metamodel.facets.FacetFactoryAbstract;

public class WizardInterfaceFacetFactory extends FacetFactoryAbstract {

    public WizardInterfaceFacetFactory() {
        super(FeatureType.OBJECTS_ONLY);
    }

    @Override
    public void process(final ProcessClassContext processClassContaxt) {
        boolean implementsInterface = Wizard.class.isAssignableFrom(processClassContaxt.getCls());
        FacetUtil.addFacet(create(implementsInterface, processClassContaxt.getFacetHolder()));
    }

    private WizardFacet create(final boolean implementsInterface, final FacetHolder holder) {
        return !implementsInterface ? null : new WizardFacetForInterface(holder);
    }

}
