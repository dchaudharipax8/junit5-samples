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

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource

import static org.junit.jupiter.api.Assertions.assertEquals

class CalculatorTestsWithCsvSource {
	Calculator calculator

	@Test
	void "1 + 1 = 2"() {
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2")
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource([
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	])
	void add(int first, int second, int expectedResult) {
		assertEquals(expectedResult, calculator.add(first, second)) {
			first + " + " + second + " should equal " + expectedResult
		}
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvFileSource(resources="/sampleUTData.csv")
	void addWithFileData(int first, int second, int expectedResult) {
		assertEquals(expectedResult, calculator.add(first, second)) {
			first + " + " + second + " should equal " + expectedResult
		}
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

	@Test
	void addWithThird() {
		assertEquals(8, calculator.addWithThird(2,4))
	}
}
