package com.globant.feature.home.profile

import com.globant.domain.repository.AccountRepository
import com.globant.domain.repository.PersonRepository
import com.globant.domain.usecases.GetAccountDetailsByIdUseCase
import com.globant.domain.usecases.GetPersonPopularUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import javax.inject.Inject

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21], application = HiltTestApplication::class)
@ExperimentalCoroutinesApi
@LooperMode(LooperMode.Mode.PAUSED)
class ProfileViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var accountRepository: AccountRepository

    @Inject
    lateinit var personRepository: PersonRepository

    @Inject
    lateinit var getAccountDetailsByIdUseCase: GetAccountDetailsByIdUseCase

    @Inject
    lateinit var getPersonPopularUseCase: GetPersonPopularUseCase

    @Mock
    private lateinit var profileViewModel: ProfileViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        profileViewModel =
            ProfileViewModel(getAccountDetailsByIdUseCase, getPersonPopularUseCase)
    }

    @Test
    fun `test account data success`() = runTest {
        val value = profileViewModel.account.value
        Assert.assertNotNull(value)
    }

    @Test
    fun `test person popular data success`() = runTest {
        val value = profileViewModel.personPopular.value
        Assert.assertNotNull(value)
    }
}
