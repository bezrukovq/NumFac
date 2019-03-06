package com.example.numfac;

import com.example.numfac.entity.Date
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacApiService
import com.example.numfac.model.NumFacModel;
import com.example.numfac.presenter.DateDetailPresenter;
import com.example.numfac.view.fragments.DateView
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.example.numfac.view.fragments.`DateView$$State`
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import kotlin.math.exp


@RunWith(MockitoJUnitRunner::class)
class DateDetailPresenterTest {

    @Mock
    lateinit var mockViewState: `DateView$$State`

    @Mock
    lateinit var mockmodel: NumFacModel

    @InjectMocks
    @Spy
    lateinit var presenter: DateDetailPresenter

    @Before
    fun setUp() = presenter.setViewState(mockViewState)

    @Test
    fun testSaveToFav(){
        //Arrange
        val mockDateDB = mock(DateDB::class.java)
        //Act
        presenter.saveToFav(mockDateDB)
        //Assert
        verify(mockmodel).addToFavList(mockDateDB)
    }

    @Test
    fun testDelFromFav() {
        //Arrange
        val mockDateDB = mock(DateDB::class.java)
        //Act
        presenter.deleteFromFav(mockDateDB)
        //Assert
        verify(mockmodel).deleteFromFavList(mockDateDB)
    }

    @Test
    fun testGetDateInfo() {
        //Arrange
        val expectedInt = 1
        val mockDate = mock(Date::class.java)
        doReturn(Single.just(mockDate)).`when`(mockmodel).getDateInfo(expectedInt)
        //Act
        presenter.getDateInfo(expectedInt)
        //Assert
        verify(mockmodel).getDateInfo(expectedInt)
        verify(mockViewState).showFact(mockDate)
        verify(mockViewState).showDate(mockDate)
        verify(mockViewState).showMonth(mockDate)
    }

    @Test
    fun testGetDateInfoWithError() {
        //Arrange
        val expectedInt = -10
        val expectedError = Throwable()
        val exeptionString = "smth go wrong"
        doReturn(Single.error<Date>(expectedError)).`when`(mockmodel).getDateInfo(-10 )
        //Act
        presenter.getDateInfo(expectedInt)
        //Assert
        verify(mockmodel).getDateInfo(expectedInt)
        verify(mockViewState).showError(exeptionString)
    }

    @Test
    fun testGetDateInfoWithError2() {
        //Arrange
        val expectedInt: Int? = null
        val expectedError = Throwable()
        doReturn(Single.error<Date>(expectedError)).`when`(mockmodel).getDateInfo(0)
        //Act
        presenter.getDateInfo(expectedInt)
        //Assert
        verify(mockmodel, never()).getDateInfo(0)
    }
}
