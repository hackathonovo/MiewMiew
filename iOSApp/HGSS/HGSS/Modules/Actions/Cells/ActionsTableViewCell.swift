//
//  ActionsTableViewCell.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import UIKit

class ActionsTableViewCell: UITableViewCell {

    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var statusLabel: UILabel!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var timeLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func configureCell(with action: RescueAction) {
        titleLabel.text = action.name
        statusLabel.text = action.rescueLifecycle?.rawValue
        dateLabel.text = action.dateTime?.formattedDate()
        timeLabel.text = action.dateTime?.formattedTime()
        descriptionLabel.text = action.actionDescription
    }

}
