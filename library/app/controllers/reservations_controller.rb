class ReservationsController < ApplicationController
  
  def index
  end
  
  def overdue 
    @reservations = Reservation.where("? > due_on", Date.current).order("user_id ASC, reserved_on ASC").page(params[:page])
  end
  
  def create
    @user = User.find_by(user_id: session[:user_id])
    @book = Book.find(params[:book_id])
    @reservation = @user.reservations.build(book_id: @book.id)      
    @book.checkout
    if @book.save
      if @reservation.save   
        redirect_to @book, notice: "Checkout was updated!"
      else
        render action: 'index'
      end
    else
      if(@book.errors.messages[:total_in_library]) 
	redirect_to @book, notice: "This book is unavailable to reserve"
      else
        redirect_to @book
      end
    end
  end

  def destroy
    @reservation = Reservation.find(params[:id])
    @book = Book.find(@reservation.book_id)
    @book.checkin
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
