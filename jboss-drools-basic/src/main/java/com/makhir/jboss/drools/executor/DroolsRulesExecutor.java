package com.makhir.jboss.drools.executor;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import com.makhir.jboss.drools.entity.CreditCard;

public class DroolsRulesExecutor {
	public static void main(String[] args) {
		String rulePath = "drools/rules/FirstRule.drl";
		try {
			fireRules(rulePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fireRules(String rule) throws Exception{
		try {
			
			KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			builder.add(ResourceFactory.newClassPathResource(rule), ResourceType.DRL);
			
			if(builder.hasErrors())
				System.out.println("Error: " + builder.getErrors().toString());
			
			CreditCard card = new CreditCard("MANHATTN", "1234567812345678", "10/2025", "VISA", "Standard Chartered");
			
			InternalKnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase();
			base.addPackages(builder.getKnowledgePackages());
			
			KieSession session = base.newKieSession();
			session.insert(card);
			session.fireAllRules();
			
			System.out.println(card.toString());
			
		} catch (Exception e) {
			System.err.println("There was a problem while executing drool rule, message : " + e.getMessage());
			throw e;
		}
	}
	
	
}
