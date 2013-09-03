package edu.cmu.cs.dickerson.kpd.solver.solution;

import java.util.Set;

import edu.cmu.cs.dickerson.kpd.structure.Cycle;
import edu.cmu.cs.dickerson.kpd.structure.Edge;
import edu.cmu.cs.dickerson.kpd.structure.Pool;
import edu.cmu.cs.dickerson.kpd.structure.Vertex;

public final class SolutionUtils {

	private SolutionUtils() {};
	
	/**
	 * Counts the number of distinguished vertices in a given solution's matching
	 * @param pool
	 * @param solution
	 * @param vertices
	 * @return
	 */
	public int countVertsInMatching(Pool pool, Solution solution, Set<Vertex> vertices) {
		
		if(null == solution || null == vertices) { return 0; }
		
		int count = 0;
		for(Cycle matchedCycle : solution.getMatching()) {
			for(Edge edge : matchedCycle.getEdges()) {
				Vertex matchedVertex = pool.getEdgeTarget(edge);
				if(vertices.contains(matchedVertex)) {
					count++;
				}
			}
		}
		
		return count;
	}
}