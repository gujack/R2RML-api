package eu.optique.r2rml.api.binding.rdf4j;

import eu.optique.r2rml.api.R2RMLMappingManagerFactory;
import eu.optique.r2rml.api.model.TriplesMap;
import eu.optique.r2rml.api.model.impl.InvalidR2RMLMappingException;
import eu.optique.r2rml.api.model.impl.R2RMLMappingManagerImpl;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.apache.commons.rdf.rdf4j.RDF4JGraph;
import org.eclipse.rdf4j.model.Model;

import java.util.Collection;

public class RDF4JR2RMLMappingManager extends R2RMLMappingManagerImpl {

    private RDF4JR2RMLMappingManager(RDF4J rdf) {
        super(rdf);
    }

    public Collection<TriplesMap> importMappings(Model model) throws InvalidR2RMLMappingException {
        return importMappings(((RDF4J) getRDF()).asGraph(model));
    }

    @Override
    public RDF4JGraph exportMappings(Collection<TriplesMap> maps) {
        return (RDF4JGraph) super.exportMappings(maps);
    }

    public static class Factory implements R2RMLMappingManagerFactory {

        /**
         * @return A R2RMLMappingManager configured with RDF4J.
         */
        @Override
        public RDF4JR2RMLMappingManager getR2RMLMappingManager() {
            return new RDF4JR2RMLMappingManager(new RDF4J());
        }

    }
}
