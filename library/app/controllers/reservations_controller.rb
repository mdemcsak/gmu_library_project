class ReservationsController < ApplicationController
  
  def index
  end

  def create
        @user = User.first
	@book = Book.find(params[:book_id])
        @reservation = @user.reservations.build(book_id: @book.id)      
	if @reservation.save   
    	  @book.total_in_library = @book.total_in_library - 1
	  @book.save
	  redirect_to @book, notice: "Checkout was updated!"
        else
	  render action: 'index'
  	end
  end

  def destroy
    @reservation = Reservation.find(params[:id])
    @book = Book.find(@reservation.book_id)
    @book.total_in_library = @book.total_in_library + 1
    @book.save
    @reservation.destroy
    redirect_to @book, notice: "Book was checked back in!"    
  end


  private

  def removeBook
    @book.total_in_library = @book.total_in_library - 1
  end

  def addBook 
    @book.total_in_library = @book.total_in_library + 1
  end
end
