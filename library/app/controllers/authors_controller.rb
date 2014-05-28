class AuthorsController < ApplicationController
    before_action :set_author,
                only: [:show]
    
    def index
      @authors = Author.all
    end

    def show
    end

    private

    def author_params
      params.require(:author).permit(:title, :dob, :nationality, :awards, :biography, :image_url)
    end

    def set_author
      @author = Author.find(params[:id])
    end

end
