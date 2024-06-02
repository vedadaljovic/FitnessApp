package com.example.fitnessapp.backend.model

class MockUserDao : UserDao {
    private val users = mutableListOf<User>()

    override suspend fun insertUser(user: User) {
        users.add(user)
    }

    override suspend fun getUser(username: String, password: String): User? {
        return users.find { it.username == username }
    }

    // Implement other methods of UserDao as needed for your testing
}
