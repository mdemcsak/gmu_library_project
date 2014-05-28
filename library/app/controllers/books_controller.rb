class BooksController < ApplicationController
    before_action :set_book,
                only: [:show, :edit, :update, :destroy]
    
    def index
        if params[:q]
            @books = Book.search(params[:q]).order(:title).page(params[:page])
        else
            @books = list_books
        end
    end

    def show
    end

    def new
        Author.setAuthors
        @book = Book.new
    end

    def create
        @book = Book.new(book_params)
        @book.author = Author::AUTHORS.key(@book.author_id)
        if @book.save
            redirect_to @book, notice: "#{@book.title} was created!"
        else
            render :new
        end
    end

    def edit
    end

    def update
        if @book.update(book_params)
            redirect_to @book, notice: "#{@book.title} was updated!"
        else
            render :new
        end
    end

    def destroy
        @book.destroy
        redirect_to books_url
    end	

    private

    def list_books
        Book.order(:title).page(params[:page])
    end

    def book_params
        params.require(:book).permit(:isbn, :title, :abstract, :author, :author_id, :pages, :image_cover_url, :genre, :published_on, :total_in_library)
    end

    def set_book
        @book = Book.find(params[:id])
    end

end
