/**
 * 
 */
package uebungen.blatt11.boids;

/**
 * Main Boids simulation program
 */
public class Boids {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		BoidSimulation simulation = new BoidSimulation(80);
		for (int x=0; x<800; x+=50)
			for (int y=0; y<=600; y+=50)
				simulation.addBoid(x,y);
		
		BoidRuleAlignment alignmentRule = new BoidRuleAlignment(0.02);
		simulation.addRule(alignmentRule);
		
		BoidRuleCohesion cohesionRule = new BoidRuleCohesion(0.045);
		simulation.addRule(cohesionRule);
		
		BoidRuleSeparation separationRule = new BoidRuleSeparation(0.5, 0.02); 		
		simulation.addRule(separationRule);
		
		BoidRuleTarget targetRule1 = new BoidRuleTarget(new Vector2(200,200), 0.6, 0.003);
		BoidRuleTarget targetRule2 = new BoidRuleTarget(new Vector2(900,200), 0.6, 0.003);
		BoidRuleTarget targetRule3 = new BoidRuleTarget(new Vector2(500,600), 0.6, 0.003);		
		simulation.addRule(targetRule1);
		simulation.addRule(targetRule2);
		simulation.addRule(targetRule3);
		
		BoidRuleLimitedSpeed limitedSpeedRule = new BoidRuleLimitedSpeed(0.002);
		simulation.addRule(limitedSpeedRule);
		
		BoidRuleWind windRule = new BoidRuleWind(new Vector2(0.06,0));
		simulation.addRule(windRule);

		BoidWindow w = new BoidWindow(simulation);
		w.addRuleView(new BoidRuleAlignmentView(alignmentRule));
		w.addRuleView(new BoidRuleCohesionView(cohesionRule));
		w.addRuleView(new BoidRuleSeparationView(separationRule));
		/** Implement This **/
		/* Ergaenzen Sie die fehlenden Views für die Regeln:
		 * - Target
		 * - LimitedSpeed
		 * - Wind
		 * so dass alle Parameter dieser Regeln in der GUI gesetzt werden koennen.
                 * Schreiben Sie dazu Getter- und Setter-Methoden wo nötig.
		 */
		//w.addRuleView(new BoidRuleTarget());
		
		int iteration=0;
		while (true) {
			Thread.sleep(10);
			simulation.epoch();
			w.updateSimulation();
			iteration=iteration+1;
		}
	}

}
