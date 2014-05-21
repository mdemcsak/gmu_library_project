class BooksController < ApplicationController
  before_action :set_book,
                only: [:show, :edit, :update, :destroy]

  def index
    @books = list_books
  end

  def show
  end

  private

  def list_books
    Book.order(:title)
  end

  def book_params
    params.require(:book).permit(:title, :abstract, :author, :pages, :image_cover_url, :genre, :published_on)
  end

  def set_book
    @book = Book.find(params[:id])
  end

end