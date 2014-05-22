class Book < ActiveRecord::Base
    has_many :reservations
    
    GENRES = ['Science Fiction', 'Historical Fiction', 'Fantasy', 'Western', 'Thriller', 'Satire']
    	
	validates :isbn, :title, :abstract, :pages, :genre, :published_on, :total_in_library, presence: true
	
	validates :pages, :total_in_library,
		numericality: { only_integer: true, greater_than_or_equal_to: 1 }
	
	validates :abstract, 
		length: { minimum: 15, too_short: "must be at least %{count} characters long." }
    
    validates :genre,
        :inclusion => { :in => GENRES }
    
    def self.search(query)
        where("title like ? or author like ? or isbn = ?", "%#{query}%", "%#{query}%", "#{query}")
    end
end
