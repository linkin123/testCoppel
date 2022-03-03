package com.tp.testcoppel.core

interface Mapper<I, O> {
    suspend fun map(input : I): O
}