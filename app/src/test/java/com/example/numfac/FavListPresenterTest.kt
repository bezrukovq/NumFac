package com.example.numfac

import com.example.numfac.entity.Date
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.FavListPresenter
import com.example.numfac.view.fragments.favList.`FavListView$$State`
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavListPresenterTest {

    @Mock
    lateinit var mockViewState: `FavListView$$State`

    @Mock
    lateinit var mockmodel: NumFacModel

    @InjectMocks
    @Spy
    lateinit var presenter: FavListPresenter

    @Before
    fun setUp() = presenter.setViewState(mockViewState)

    @Test
    fun testSetDateListAllCorrect() {
        //Arrange
        val datesList : List<DateDB> = ArrayList<DateDB>()
        doReturn(Single.just(datesList)).`when`(mockmodel).getFavDateList()
        //Act
        presenter.setDateList()
        //Assert
        verify(mockmodel).getFavDateList()
        verify(mockViewState).showDateList(datesList)
    }

    @Test
    fun testOpenDate(){
        //Arrange
        val mockDateDB = Mockito.mock(DateDB::class.java)
        //Act
        presenter.openDate(mockDateDB)
        //Assert
        verify(mockViewState).openDate(mockDateDB)
    }
}