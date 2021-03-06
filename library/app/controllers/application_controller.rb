class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception
  before_action :authorize

  protected
  
  def authorize
    unless User.find_by(user_id: session[:user_id])
      redirect_to new_session_path, notice: "Please log in"
    end
  end

end
