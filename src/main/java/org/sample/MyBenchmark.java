package org.sample;

import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.sample.dumbclasses.*;

public class MyBenchmark {
	
	private static final List<Base> INSTANCES = List.of(new A(), new B(), new C(), new D(), new E(), new F());
	private static final List<Class<? extends Base>> CLASSES = List.of(A.class, B.class, C.class, D.class, E.class, F.class);


    @Benchmark
    public void testInstanceOf() {
        for (Base instance : INSTANCES) {
        	if (instance instanceof A
        			|| instance instanceof B
        			|| instance instanceof C
        			|| instance instanceof D
        			|| instance instanceof E
        			|| instance instanceof F) {
        		instance.echo();
        	}
        }
    }
    
    @Benchmark
    public void testFromList() {
    	for (Base instance : INSTANCES) {
    		if (CLASSES.contains(instance.getClass())) {
    			instance.echo();
    		}
    	}
    }
}
