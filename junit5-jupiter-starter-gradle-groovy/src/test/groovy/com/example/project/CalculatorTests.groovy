/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

import static org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class CalculatorTests {
	Calculator calculator

	@Test
	void "1 + 1 = 2"() {
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2")
	}

	@BeforeEach
	void setUp(){
		println "BeforeEach test"
		calculator = new Calculator()
		calculator.third = 2
	}

	@AfterEach
	void tearDown(){
		println "AfterEach test"
		calculator = null
	}

	@BeforeAll
	static void setUpBeforeAll(){   //Please note the "static" keyword
		println "BeforeAll Tests"
	}

	@AfterAll
	static void tearDownAfterAll(){     //Please note the "static" keyword
		println "AfterAll Tests"
	}

	@Test
	void addWithThird() {
		assertEquals(8, calculator.addWithThird(2,4))
	}
}
